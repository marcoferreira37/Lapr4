package plugin.structure;

import org.antlr.v4.runtime.tree.ErrorNode;
import plugin.antlr4.autogen.requirements.JobRequirementsGrammarBaseVisitor;

public class RequirementsValidatorVisitor extends JobRequirementsGrammarBaseVisitor<Object> {



    @Override
    public Object visitErrorNode(ErrorNode node) {
        throw new RuntimeException("Entered file is not a valid requirements file.");
    }
}
