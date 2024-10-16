package com.backend.firstproject.model;

public class Constants {
    public enum Gender {
        MALE,
        FEMALE
    }

    public enum EntryType {
        FRESH_ENTRY,
        DIRECT_ENTRY,
        DEGREE_TOPUP
    }

    public enum AdmissionStatus {
        REJECTED,
        PENDING,
        ACCEPTED
    }
}