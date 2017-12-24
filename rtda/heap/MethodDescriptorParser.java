package rtda.heap;

public class MethodDescriptorParser {

    String raw;
    int offset;
    MethodDescriptor parsed;

    public static MethodDescriptor parseMethodDescriptor(String descriptor) {
        MethodDescriptorParser parser = new MethodDescriptorParser();
        return parser.parse(descriptor);
    }

    private MethodDescriptor parse(String descriptor) {
        this.raw = descriptor;
        this.parsed = new MethodDescriptor();
        this.startParams();
        this.parseParamTypes();
        this.endParams();
        this.parseReturnType();
        this.finish();
        return this.parsed;
    }

    private void startParams() {
        if (readUint8() != '(') {
            causePanic();
        }
    }

    private void endParams() {
        if (readUint8() != ')') {
            causePanic();
        }
    }

    private void finish() {
        if (offset != raw.length()) {
            causePanic();
        }
    }


    private void causePanic() {
        System.out.println("bad descriptor: " + raw);
        System.exit(0);
    }

    private char readUint8() {
        char b = raw.charAt(offset);
        offset++;
        return b;
    }

    private void unreadUint8() {
        offset--;
    }

    private void parseParamTypes() {
        while(true) {
            String t = parseFieldType();
            if (null != t && t != "") {
                parsed.addParameterType(t);
            } else {
                break;
            }
        }
    }

    private void parseReturnType() {
        if (readUint8() == 'V') {
            parsed.returnType = "V";
            return;
        }

        unreadUint8();
        String t = parseFieldType();
        if (null != t && t != "") {
            parsed.returnType = t;
            return;
        }

        causePanic();
    }

    private String parseFieldType() {
        switch (readUint8()) {
            case 'B':
                return "B";
            case 'C':
                return "C";
            case 'D':
                return "D";
            case 'F':
                return "F";
            case 'I':
                return "I";
            case 'J':
                return "J";
            case 'S':
                return "S";
            case 'Z':
                return "Z";
            case 'L':
                return parseObjectType();
            case '[':
                return parseArrayType();
            default:
                unreadUint8();
                return "";
        }
    }

    private String parseObjectType() {
        String unread = raw.substring(offset, raw.length());
        int semicolonIndex = unread.indexOf(';');
        if (semicolonIndex == -1) {
            causePanic();
            return "";
        } else {
            int objStart = offset - 1;
            int objEnd = offset + semicolonIndex + 1;
            offset = objEnd;
            String descriptor = raw.substring(objStart, objEnd);
            return descriptor;
        }
    }

    private String parseArrayType() {
        int arrStart = offset - 1;
        parseFieldType();
        int arrEnd = offset;
        String descriptor = raw.substring(arrStart, arrEnd);
        return descriptor;
    }


}
