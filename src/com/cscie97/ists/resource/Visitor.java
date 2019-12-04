package com.cscie97.ists.resource;

public interface Visitor {

    void visitResourceImpl(ResourceManagementService resourceImpl);
    void visitTeam(Team team);
    void visitPerson(Person person);
}
