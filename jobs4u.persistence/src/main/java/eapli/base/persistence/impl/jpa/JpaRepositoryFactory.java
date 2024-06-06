/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.domain.jobOpeningProcess.JobOpeningProcess;
import eapli.base.persistence.impl.inmemory.InMemoryJobOpeningProcessRepository;
import eapli.base.repositories.*;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.jpa.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public Ijobs4UUserRepository jobs4UUsers() {
        return new JpaJobs4UUserRepository();
    }

    @Override
    public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository clientUsers() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CustomerRepository customer() {
        return new JpaCustomerRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CandidateRepository candidate() {
        return new JpaCandidateRepository((Application.settings().getPersistenceUnitName()));
    }

    @Override
    public CompanyRepository customer(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public JobOpeningRepository jobOpeningRepository(final TransactionalContext autoTx) {
        return new JpaJobOpeningRepository(autoTx);
    }

    @Override
    public JobOpeningRepository jobOpeningRepository() {
        return new JpaJobOpeningRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CompanyRepository companyRepository(final TransactionalContext autoTx) {
        return new JpaCompanyRepository(autoTx);
    }
    @Override
    public CompanyRepository companyRepository() {
        return new JpaCompanyRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CandidateRepository candidateRepository(TransactionalContext autoTx) {
        return new JpaCandidateRepository(autoTx);
    }

    @Override
    public CandidateRepository candidateRepository() {
        return new JpaCandidateRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JobOpeningProcessRepository jobProcessRepository(TransactionalContext autoTx) {
        return new JpaJobProcessRepository(autoTx);
    }

    @Override
    public JobOpeningProcessRepository jobProcessRepository() {
        return new JpaJobProcessRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JobInterviewRepository jobInterviewRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public JobInterviewRepository jobInterviewRepository() {
        return null;
    }

    @Override
    public JobOpeningApplicationRepository jobApplicationsRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public JobOpeningApplicationRepository jobApplicationsRepository() {
        return null;
    }

    @Override
    public JobOpeningRepository jobOpening(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public JobOpeningRepository jobOpening() {
        return null;
    }

    @Override
    public CompanyRepository company(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public JobOpeningApplicationRepository JobApplications(TransactionalContext autoTx) {
        return new JpaJobApplicationRepository(autoTx);
    }

    @Override
    public JobOpeningApplicationRepository jobApplications() {
        return new JpaJobApplicationRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JobInterviewRepository jobInterviews() {
        return new JpaJobInterviewRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JobInterviewRepository jobInterviews(TransactionalContext autoTx) {
        return new JpaJobInterviewRepository(autoTx);
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JobOpeningProcessRepository jobProcess(){
        return new JpaJobProcessRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JobOpeningProcessRepository jobProcess(TransactionalContext autoTx) {
        return new JpaJobProcessRepository(autoTx);
    }

}
