
# Lab 2 Solutions

## 1. Extended Project Management Class Diagram

Based on the extended version of Lab 1's Project Management system, the following classes, attributes, and relationships are suggested:

### Classes and Attributes

- **Project**
  - projectId: String
  - featureSet: List<Feature>
  - releaseList: List<Release>

- **Release**
  - releaseDate: Date
  - features: List<Feature>

- **Developer**
  - developerId: String
  - assignedFeatures: List<Feature>

- **Feature**
  - featureId: String
  - estimatedTime: int
  - developer: Developer

### Relationships
- Project has many Releases (1 to *)
- Project has many Features (1 to *)
- Release has many Features (1 to *)
- Feature is assigned to one Developer (1 to 1)

## 2. Java Class Implementations

### prob2A

```java
package prob2A;

public class Student {
    private String name;
    private GradeReport report;

    public Student(String name) {
        this.name = name;
        this.report = new GradeReport(this);
    }
}

public class GradeReport {
    private Student student;

    public GradeReport(Student student) {
        this.student = student;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Alice");
        // GradeReport is automatically created and associated
    }
}
```

### prob2B

```java
package prob2B;

import java.util.*;

public class Order {
    private String orderNum;
    private List<OrderLine> lines;

    public Order(String orderNum) {
        this.orderNum = orderNum;
        this.lines = new ArrayList<>();
    }

    public void addOrderLine(OrderLine line) {
        lines.add(line);
    }
}

public class OrderLine {
    private Order order;

    public OrderLine(Order order) {
        this.order = order;
        order.addOrderLine(this);
    }
}

public class Main {
    public static void main(String[] args) {
        Order o = new Order("ORD123");
        OrderLine ol1 = new OrderLine(o);
        OrderLine ol2 = new OrderLine(o);
    }
}
```

## 3. Class Diagrams

### A. Position Hierarchy

```plaintext
+------------------+
|    Position      |
+------------------+
| - id: String     |
| - title: String  |
| - manager: Position |
+------------------+
| - reports: List<Position> |
+------------------+
```

### B. Course Prerequisites

```plaintext
+----------------------+
|       Course         |
+----------------------+
| - courseId: String   |
| - title: String      |
+----------------------+
| - prerequisites: List<Course> |
+----------------------+
```

These diagrams show recursive relationships (self-referencing) to model hierarchy and prerequisites.
