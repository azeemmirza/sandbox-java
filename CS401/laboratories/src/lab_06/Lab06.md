(a)- PatientNumber → FullName, BedNumber, WardNumber, WardName.
- DrugNumber → Name, Description, Dosage.
- {PatientNumber, DrugNumber, StartDate} → MethodOfAdmin, UnitsPerDay, FinishDate.

(b)
UNF: Data contains repeating groups (multiple drugs per patient).

1NF: Remove repeating groups → each row holds one drug per patient.

2NF: Remove partial dependencies.
Create:
- Patient(PatientNumber [PK], FullName, BedNumber, WardNumber, WardName).
- Drug(DrugNumber [PK], Name, Description, Dosage).
- PatientDrug(PatientNumber [FK], DrugNumber [FK], StartDate, MethodOfAdmin, UnitsPerDay, FinishDate).
- PK: (PatientNumber, DrugNumber, StartDate).

3NF: No transitive dependencies.
All non-key attributes depend only on keys.

(c)
1. Patient:
Primary Key (PK): PatientNumber.
Alternate Key: None.
Foreign Keys: None.

2. Drug:
Primary Key (PK): DrugNumber.
Alternate Key: None.
Foreign Keys: None.

3. PatientDrugAdministration:
Primary Key (PK): (PatientNumber, DrugNumber, StartDate).
Alternate Key: None.
Foreign Keys:
    - PatientNumber → Patient.PatientNumber.
    - DrugNumber → Drug.DrugNumber.