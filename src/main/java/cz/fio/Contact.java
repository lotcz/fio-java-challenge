package cz.fio;

import java.util.Objects;

/**
 * Represents a single contact. Implements equals() to compare contacts based on property values.
 */
public class Contact {

    private String firstName;

    private String lastName;

    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = StringUtil.trimToNull(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = StringUtil.trimToNull(lastName);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = StringUtil.trimToNull(email);
    }

    /**
     * Check validity of the contact. Contact must have at least one property set to be valid.
     * @return True if contact is valid.
     */
    public boolean isValid() {
        return this.firstName != null || this.lastName != null || this.email != null;
    }

    private boolean equals(Contact other) {
        assert other != null;

        return Objects.equals(this.firstName, other.firstName)
                && Objects.equals(this.lastName, other.lastName)
                && Objects.equals(this.email, other.email);
    }

    /**
     * Consider other contact to be equal if same object or all properties are same.
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Contact) {
            return this.equals((Contact)other);
        } else {
            return false;
        }
    }
}
