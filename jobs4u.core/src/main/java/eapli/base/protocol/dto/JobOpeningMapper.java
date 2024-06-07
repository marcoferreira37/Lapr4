package eapli.base.protocol.dto;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningProcess.JobOpeningProcess;

public class JobOpeningMapper {
    public static JobOpeningDTO toDTO(JobOpening jobOpening, JobOpeningProcess process) {
        return new JobOpeningDTO(
                jobOpening.getJobReference(),
                jobOpening.getDescription(),
                jobOpening.getAddress(),
                jobOpening.getMode(),
                jobOpening.getContractType(),
                jobOpening.getTitleOrFunction(),
                jobOpening.getVacanciesNumber(),
                jobOpening.getCompany().getCompanyName().companyName(),
                jobOpening.getCreationDate(),
                jobOpening.getInterviewModel(),
                jobOpening.getRequirements(),
                process.status()
        );
    }
}

