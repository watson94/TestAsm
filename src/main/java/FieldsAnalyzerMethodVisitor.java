import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.HashMap;
import java.util.Map;

public class FieldsAnalyzerMethodVisitor extends MethodVisitor {

    private Map<Field, Boolean> fieldModes = new HashMap<Field, Boolean>(); //false - read, true - write
    private String className;
    private String methodName;

    public FieldsAnalyzerMethodVisitor(MethodVisitor mv, String className, String methodName) {
        super(Opcodes.ASM4, mv);
        this.className = className;
        this.methodName = methodName;
    }

    @Override
    public void visitFieldInsn(int opc, String owner, String name, String desc) {
        Field field = new Field(owner, name);
        Boolean mode = false;
        if (fieldModes.containsKey(field)) {
            mode = fieldModes.get(field);
        }
        Boolean newMode = (opc == Opcodes.PUTSTATIC || opc == Opcodes.PUTFIELD);
        fieldModes.put(field, mode || newMode);
    }

    @Override
    public void visitEnd() {
        System.out.println(className + "." + methodName);
        for (Map.Entry<Field, Boolean> e : fieldModes.entrySet()) {
            System.out.println("    " + (e.getValue() ? "Write " : "Read ") + e.getKey().getFullName());
        }
    }
}
