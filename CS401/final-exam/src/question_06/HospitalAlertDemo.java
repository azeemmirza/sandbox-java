package question_06;

class HospitalAlertDemo {
    public static void main(String[] args) {
        NotificationService.INSTANCE.sendAlert("Emergency in Ward 7");
    }
}

/**
 * Why enum singleton is preferred over traditional singleton:
 * Enum singletons are inherently thread-safe and handle serialization correctly by default.
 * Java ensures that only one instance of an enum is created, even in complex cases like
 * deserialization or reflection. Traditional singleton patterns require extra effort to protect
 * against reflection and serialization issues.
*/
