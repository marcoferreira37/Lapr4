package eapli.base.domain.jobOpeningProcess;

public enum PhaseType {
    REVIEW,
    APPLICATION,
    SCREENING,
    INTERVIEWS,
    ANALYSIS,
    RESULT;

    public PhaseType nextPhase(boolean interviewPhase) {
        if (interviewPhase) {
            return INTERVIEWS;
        }
        if(this == REVIEW){
            return REVIEW;
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
            return REVIEW;
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
