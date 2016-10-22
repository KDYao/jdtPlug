package jdtplug.handlers;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * javaԴ�ļ���������
 */
public class JdtAst {

    @SuppressWarnings("deprecation")
	private ASTParser astParser = ASTParser.newParser(AST.JLS3); // �ǳ���
    /**
     * parser only one java file
     * ���javaԴ�ļ��ĽṹCompilationUnit
     */
    public CompilationUnit getCompilationUnit(ICompilationUnit unit)
            throws CoreException {

        this.astParser.setResolveBindings(true);//
        this.astParser.setKind(ASTParser.K_COMPILATION_UNIT);//
        this.astParser.setBindingsRecovery(true);//
        @SuppressWarnings("rawtypes")
		Map options = JavaCore.getOptions();
        this.astParser.setCompilerOptions(options);
		this.astParser.setSource(unit);//�������趨��ASTParser
        CompilationUnit result = (CompilationUnit) (this.astParser.createAST(null)); //Դ������AST��ת��
        //createAST()�����Ĳ�������ΪIProgressMonitor�����ڶ�AST��ת�����м�أ�����Ҫ�Ļ������null����
        return result;

    }
}
