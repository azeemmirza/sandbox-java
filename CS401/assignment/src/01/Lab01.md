# Lab 1 Solutions

## WITHDRAW_MONEY Use Case Description: Main Flow

| **User Action**                            | **System Response**                                                           |
|-------------------------------------------|--------------------------------------------------------------------------------|
| 1. User types in PIN into main screen     | 1. System checks validity of PIN and presents options to user on another screen |
| 2. User selects “Withdraw Money”          | 2. System displays account types (Checking/Savings) and prompts for selection |
| 3. User selects account and enters amount | 3. System verifies funds, dispenses cash, and updates account balance         |

---

## User Story
As an ATM user, I want to withdraw money by entering my PIN, selecting an account, and specifying the amount so that I can quickly receive the desired cash from my account.

---

## Use Case Diagram – ATM System (Textual Representation)

**Actors:**
- ATM User
- Bank System

**Use Cases:**
- Enter PIN
- Withdraw Money
- Check Balance

ATM User ↔ Enter PIN  
ATM User ↔ Withdraw Money  
ATM User ↔ Check Balance

---

## Project Management Tracking System – Class Diagram

### Classes and Attributes

1. **ProjectManager**
    - name
    - id

2. **Project**
    - name
    - id
    - featureSet
    - releaseList

3. **Feature**
    - description
    - estimatedTime
    - assignedDeveloper

4. **Developer**
    - name
    - id

5. **Release**
    - releaseDate
    - featureSubset

---

## Properties Management System – Class Diagram

### Classes and Attributes

1. **Property**
    - address
    - rent (calculated in subclass)

2. **House** (extends Property)
    - lotSize

3. **Condominium** (extends Property)
    - numberOfFloors

4. **Trailer** (extends Property)
    - trailerParkAddress

5. **Admin**
    - name
    - id
