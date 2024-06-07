package plugin.structure;

import org.antlr.v4.runtime.tree.ErrorNode;
import plugin.antlr4.autogen.interview.InterviewModelGrammarBaseVisitor;

public class JobInterviewValidatorVisitor  extends InterviewModelGrammarBaseVisitor<Object> {
    @Override
    public Object visitErrorNode(ErrorNode node) {
        throw new RuntimeException( "Entered file is not a valid interview file.");
    }
}
