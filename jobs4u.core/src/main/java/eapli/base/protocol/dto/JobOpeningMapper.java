package eapli.base.protocol.dto;

import eapli.base.domain.jobOpening.JobOpening;

public class JobOpeningMapper {
    public static JobOpeningDTO toDTO(JobOpening jobOpening) {
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
                jobOpening.getRequirements()
        );
    }
}

