/* *
 * Gerald Arocena
 * CSCI E-97
 * Professor: Eric Gieseke
 * Assignment 4
 */

package com.cscie97.ists.authentication;

import java.util.LinkedHashMap;

/* *
 * Represents a Role, e.g., that Users can have. Extends Entitlement (so can be used in a Composite design pattern as a composite)
 */
public class Role extends Entitlement
{
    /* Variables */
  
    protected LinkedHashMap<String, Entitlement> entitlements;
    
    /* Constructor */
    
    public Role(String id, String name, String description)
    {
        super(id, name, description);
        
        entitlements = new LinkedHashMap<String, Entitlement>();        
    }
    
    /* Methods */
    
    public void addEntitlement(Entitlement entitlement)
    {
        entitlements.put(entitlement.getId(), entitlement);
    }     

    /* Getters and Setters */
    
    public LinkedHashMap<String, Entitlement> getEntitlements()
    {
        return entitlements;
    }

    @Override
    public void acceptVisitor(Visitor visitor)
    {
        visitor.visitRole(this);
    }
}
