import org.objectweb.asm.*;

/**
 * Created by watson on 04.02.15.
 */
public class MyClassVisitor extends ClassVisitor {
    private String className;
    public MyClassVisitor() {
        super(Opcodes.ASM4);
    }

    public void visit(int version, int access, String name,
                      String signature, String superName, String[] interfaces) {
        this.className = name;
    }


    public void visitInnerClass(String name, String outerName,
                                String innerName, int access) {
    }

    public MethodVisitor visitMethod(int access, String name,
                                     String desc, String signature, String[] exceptions) {
        return new FieldsAnalyzerMethodVisitor(super.visitMethod(access, name, desc, signature, exceptions), className, name);
    }

    public void visitEnd() {
    }
}