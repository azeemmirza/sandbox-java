package Laboratory04.Problem43.employeeinfo;

/**
 * Enum to represent the different types of bank accounts.
 */
public enum AccountType {
    CHECKING,
    SAVINGS,
    RETIREMENT;

    /**
     * Returns a user-friendly string representation of the account type.
     * e.g., "Checking" instead of "CHECKING".
     * @return A capitalized string of the enum name.
     */
    @Override
    public String toString() {
        String name = name(); // Gets "CHECKING", "SAVINGS", etc.
        if (name.isEmpty()) {
            return "";
        }
        return name.charAt(0) + name.substring(1).toLowerCase();
    }
}
