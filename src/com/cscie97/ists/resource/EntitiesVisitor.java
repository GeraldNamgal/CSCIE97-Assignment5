package com.cscie97.ists.resource;

import java.util.Map.Entry;

public class EntitiesVisitor implements Visitor {

    Integer baseLevel = 0;
    Integer tabSpace = 4;
    Integer levelPtr;
    String inventory;       
    
    @Override
    public void visitResourceImpl(ResourceManagementService resourceImpl) {
        
        Integer level = baseLevel.intValue();
        
        for (Entry<String, Entity> entityEntry : resourceImpl.getEntities(null).entrySet())
        {       
            traverseTreeAndPrint(entityEntry.getValue(), level);              
        }
        
    }

    @Override
    public void visitTeam(Team team) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitPerson(Person person) {
        // TODO Auto-generated method stub
        
    }
    
    public void traverseTreeAndPrint(Visitable entity, Integer level)
    {
        levelPtr = level.intValue();
        
        for (int i = 0; i < level * tabSpace; i++)
            System.out.print(" ");
        System.out.print("|");
        
        // Call entitlement's acceptVisitor method
        entity.acceptVisitor(this);
                       
        // If current node is a Role, recurse
        if (entity.getClass().getName().endsWith(".Team"))
        {           
            Integer newLevel = level + 1;
            
            // Recurse on Team
        }              
    }
}
