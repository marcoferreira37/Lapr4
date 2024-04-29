/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.usermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.RoleAssignment;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.*;

/**
 * @author Paulo Gandra Sousa
 *
 */
public final class BaseRoles implements Set<RoleAssignment>, Serializable {
    /**
     * poweruser
     */
    public static final Role POWER_USER = Role.valueOf("POWER_USER");
    /**
     * operator
     */
    public  static final Role OPERATOR = Role.valueOf("OPERATOR");
    /**
     * Utente
     */
    public static final Role CLIENT_USER = Role.valueOf("CLIENT_USER");
    /**
     * Base Administrator
     */
    public static final Role ADMIN = Role.valueOf("ADMIN");
    /**
     *
     */
    public static final Role KITCHEN_MANAGER = Role.valueOf("KITCHEN_MANAGER");
    /**
     *
     */
    public static final Role MENU_MANAGER = Role.valueOf("MENU_MANAGER");
    /**
     *
     */
    public static final Role CASHIER = Role.valueOf("CASHIER");

    public static final Role CUSTOMER_MANAGER = Role.valueOf("CUSTOMER_MANAGER");

    public static final Role CUSTOMER = Role.valueOf("CUSTOMER");
    public static final Role CANDIDATE = Role.valueOf("CANDIDATE");
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<RoleAssignment> assignments = new HashSet<>();

    /**
     * get available role types for adding new users
     *
     * @return
     */
    public static Role[] nonUserValues() {
        return new Role[] { ADMIN, KITCHEN_MANAGER, MENU_MANAGER, CASHIER, CUSTOMER, CUSTOMER_MANAGER};
    }

    public boolean isCollaborator(final Role role) {
        return role != CLIENT_USER;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<RoleAssignment> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(RoleAssignment roleAssignment) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(final Collection<? extends RoleAssignment> arg0) {
        return assignments.addAll(arg0);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
