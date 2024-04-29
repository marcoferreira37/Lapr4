package eapli.base.domain.jobOpening;

import eapli.base.domain.company.Company;

public class JobOpeningBuilder {

    private JobReference jobReference;
    private Description description;
    private Address address;
    private Mode mode;
    private TitleOrFunction titleOrFunction;
    private VacanciesNumber vacanciesNumber;
    private Company company;

    public JobOpeningBuilder withJobReference(JobReference jobReference) {
        this.jobReference = jobReference;
        return this;
    }

    public JobOpeningBuilder withDescription(Description description) {
        this.description = description;
        return this;
    }

    public JobOpeningBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    public JobOpeningBuilder withMode(Mode mode) {
        this.mode = mode;
        return this;
    }

    public JobOpeningBuilder withCompany(Company company) {
        this.company = company;
        return this;
    }

    public JobOpeningBuilder withTitleOrFunction(TitleOrFunction titleOrFunction) {
        this.titleOrFunction = titleOrFunction;
        return this;
    }

    public JobOpeningBuilder withVacanciesNumber(VacanciesNumber vacanciesNumber) {
        this.vacanciesNumber = vacanciesNumber;
        return this;
    }

    public JobOpening build() {
        JobOpening jobOpening = new JobOpening();
        jobOpening.setJobReference(jobReference);
        jobOpening.setDescription(description);
        jobOpening.setAddress(address);
        jobOpening.setMode(mode);
        jobOpening.setTitleOrFunction(titleOrFunction);
        jobOpening.setVacanciesNumber(vacanciesNumber);
        jobOpening.setCompany(company);
        return jobOpening;
    }
}

