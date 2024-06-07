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
package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.repositories.*;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.inmemory.InMemoryUserRepository;

/**
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new BaseBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public Ijobs4UUserRepository jobs4UUsers() {
        return null;
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {

        return new InMemoryClientUserRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    @Override
    public NotificationsRepository notifications() {
        return notificationsRepository(null);

    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public CustomerRepository customer() {
        return null;
    }

    @Override
    public CandidateRepository candidate() {
        return null;
    }

    @Override
    public CompanyRepository customer(TransactionalContext autoTx) {
        return new InMemoryCompanyRepository();
    }


    @Override
    public JobOpeningRepository jobOpeningRepository(TransactionalContext autoTx) {
        return new InMemoryJobOpeningRepository();
    }

    @Override
    public JobOpeningRepository jobOpeningRepository() {
        return new InMemoryJobOpeningRepository();
    }

    @Override
    public CompanyRepository companyRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public CompanyRepository companyRepository() {
        return new InMemoryCompanyRepository();
    }

    @Override
    public CandidateRepository candidateRepository(TransactionalContext autoTx) {
        return new InMemoryCandidateRepository();
    }

    @Override
    public CandidateRepository candidateRepository() {
        return candidateRepository(null);
    }

    @Override
    public JobOpeningProcessRepository jobProcessRepository(TransactionalContext autoTx) {
        return new InMemoryJobOpeningProcessRepository();
    }

    @Override
    public JobOpeningProcessRepository jobProcessRepository() {
        return null;
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
        return new InMemoryJobApplicationRepository();
    }

    @Override
    public JobOpeningApplicationRepository jobApplications() {
        return JobApplications(null);
    }

    @Override
    public JobInterviewRepository jobInterviews(TransactionalContext autoTx) {
        return new InMemoryJobInterviewRepository();
    }


    @Override
    public JobInterviewRepository jobInterviews() {
        return jobInterviews(null);
    }

    @Override
    public JobOpeningProcessRepository jobProcess(TransactionalContext autoTx) {
        return new InMemoryJobOpeningProcessRepository();
    }

    @Override
    public JobOpeningProcessRepository jobProcess() {
        return jobProcess(null);
    }

    @Override
    public NotificationsRepository notificationsRepository(TransactionalContext autoTx) {
        return new InMemoryNotificationsRepository();
    }

    @Override
    public NotificationsRepository notificationsRepository() {
        return notificationsRepository(null);
    }


    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

}
