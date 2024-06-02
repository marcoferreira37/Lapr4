package eapli.base.domain.jobOpeningProcess;

public enum PhaseType {
    DRAFT,
    APPLICATION,
    SCREENING,
    INTERVIEWS,
    ANALYSIS,
    RESULT;

    public PhaseType nextPhase(boolean interviewPhase) {
        if (interviewPhase) {
            return INTERVIEWS;
        }
        if(this == DRAFT){
            return APPLICATION;
        }
        if (this == APPLICATION) {
            return SCREENING;
        } else if (this == SCREENING) {
            return ANALYSIS;
        } else if (this == INTERVIEWS) {
            return ANALYSIS;
        } else if (this == ANALYSIS) {
            return RESULT;
        } else {
            return null;
        }
    }

    public PhaseType previousPhase(boolean interviewPhase) {

        if (interviewPhase) {
            return INTERVIEWS;
        }

        if (this== APPLICATION){
            return DRAFT;
        }
        if (this == SCREENING) {
            return APPLICATION;
        } else if (this == INTERVIEWS) {
            return SCREENING;
        } else if (this == ANALYSIS) {
            return SCREENING;
        } else if (this == RESULT) {
            return ANALYSIS;
        } else {
            return null;
        }
    }
}
