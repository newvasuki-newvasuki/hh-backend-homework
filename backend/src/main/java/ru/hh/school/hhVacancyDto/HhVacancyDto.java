package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.hh.school.hhEmployerDto.HhError;

import java.util.List;

public class HhVacancyDto {

    private String id;
    private String description;
    private String brandedDescription;
    private List<KeySkill> keySkills = null;
    private Schedule schedule;
    private Boolean acceptHandicapped;
    private Boolean acceptKids;
    private Experience experience;
    private Address address;
    private String alternateUrl;
    private String applyAlternateUrl;
    private String code;
    private Department department;
    private Employment employment;
    private Salary salary;
    private Boolean archived;
    private String name;
    private InsiderInterview insiderInterview;
    private Area area;
    private String createdAt;
    private String publishedAt;
    private Employer employer;
    private Boolean responseLetterRequired;
    private Type type;
    private Boolean hasTest;
    private String responseUrl;
    private Test test;
    private List<Specialization> specializations = null;
    private Contacts contacts;
    private BillingType billingType;
    private Boolean allowMessages;
    private Boolean premium;
    private List<DriverLicenseType> driverLicenseTypes = null;
    private Boolean acceptIncompleteResumes;
    private List<WorkingDay> workingDays = null;
    private List<WorkingTimeInterval> workingTimeIntervals = null;
    private List<WorkingTimeMode> workingTimeModes = null;
    private Boolean acceptTemporary;
    private List<ProfessionalRole> professionalRoles = null;
    private List<String> relations;
    private Site site;
    private String vacancyConstructorTemplate;
    private String hidden;
    private boolean quickResponsesAllowed;
    private String negotiationsUrl;
    private String suitableResumesUrl;
    private String    requestId;
    private List<HhError> errors = null;

    public HhVacancyDto(@JsonProperty("id") String id,
                        @JsonProperty("description") String description,
                        @JsonProperty("branded_description") String brandedDescription,
                        @JsonProperty("key_skills") List<KeySkill> keySkills,
                        @JsonProperty("schedule") Schedule schedule,
                        @JsonProperty("accept_handicapped") Boolean acceptHandicapped,
                        @JsonProperty("accept_kids") Boolean acceptKids,
                        @JsonProperty("experience") Experience experience,
                        @JsonProperty("address") Address address,
                        @JsonProperty("alternate_url") String alternateUrl,
                        @JsonProperty("apply_alternate_url") String applyAlternateUrl,
                        @JsonProperty("code") String code,
                        @JsonProperty("department") Department department,
                        @JsonProperty("employment") Employment employment,
                        @JsonProperty("salary") Salary salary,
                        @JsonProperty("archived") Boolean archived,
                        @JsonProperty("name") String name,
                        @JsonProperty("insider_interview") InsiderInterview insiderInterview,
                        @JsonProperty("area") Area area,
                        @JsonProperty("created_at") String createdAt,
                        @JsonProperty("published_at") String publishedAt,
                        @JsonProperty("employer") Employer employer,
                        @JsonProperty("response_letter_required") Boolean responseLetterRequired,
                        @JsonProperty("type") Type type,
                        @JsonProperty("has_test") Boolean hasTest,
                        @JsonProperty("response_url") String responseUrl,
                        @JsonProperty("test") Test test,
                        @JsonProperty("specializations") List<Specialization> specializations,
                        @JsonProperty("contacts") Contacts contacts,
                        @JsonProperty("billing_type") BillingType billingType,
                        @JsonProperty("allow_messages") Boolean allowMessages,
                        @JsonProperty("premium") Boolean premium,
                        @JsonProperty("driver_license_types") List<DriverLicenseType> driverLicenseTypes,
                        @JsonProperty("accept_incomplete_resumes") Boolean acceptIncompleteResumes,
                        @JsonProperty("working_days") List<WorkingDay> workingDays,
                        @JsonProperty("working_time_intervals") List<WorkingTimeInterval> workingTimeIntervals,
                        @JsonProperty("working_time_modes") List<WorkingTimeMode> workingTimeModes,
                        @JsonProperty("accept_temporary") Boolean acceptTemporary,
                        @JsonProperty("professional_roles") List<ProfessionalRole> professionalRoles,
                        @JsonProperty("relations") List<String> relations,
                        @JsonProperty("site") Site site,
                        @JsonProperty("vacancy_constructor_template") String vacancyConstructorTemplate,
                        @JsonProperty("hidden") String hidden,
                        @JsonProperty("quick_responses_allowed") boolean quickResponsesAllowed,
                        @JsonProperty("negotiations_url") String negotiationsUrl,
                        @JsonProperty("suitable_resumes_url") String suitableResumesUrl,
                        @JsonProperty("request_id")           String     requestId,
                        @JsonProperty("errors")                List<HhError>        errors) {
        this.id = id;
        this.description = description;
        this.brandedDescription = brandedDescription;
        this.keySkills = keySkills;
        this.schedule = schedule;
        this.acceptHandicapped = acceptHandicapped;
        this.acceptKids = acceptKids;
        this.experience = experience;
        this.address = address;
        this.alternateUrl = alternateUrl;
        this.applyAlternateUrl = applyAlternateUrl;
        this.code = code;
        this.department = department;
        this.employment = employment;
        this.salary = salary;
        this.archived = archived;
        this.name = name;
        this.insiderInterview = insiderInterview;
        this.area = area;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.employer = employer;
        this.responseLetterRequired = responseLetterRequired;
        this.type = type;
        this.hasTest = hasTest;
        this.responseUrl = responseUrl;
        this.test = test;
        this.specializations = specializations;
        this.contacts = contacts;
        this.billingType = billingType;
        this.allowMessages = allowMessages;
        this.premium = premium;
        this.driverLicenseTypes = driverLicenseTypes;
        this.acceptIncompleteResumes = acceptIncompleteResumes;
        this.workingDays = workingDays;
        this.workingTimeIntervals = workingTimeIntervals;
        this.workingTimeModes = workingTimeModes;
        this.acceptTemporary = acceptTemporary;
        this.professionalRoles = professionalRoles;
        this.relations = relations;
        this.site = site;
        this.vacancyConstructorTemplate = vacancyConstructorTemplate;
        this.hidden = hidden;
        this.quickResponsesAllowed = quickResponsesAllowed;
        this.negotiationsUrl = negotiationsUrl;
        this.suitableResumesUrl = suitableResumesUrl;
        this.errors = errors;
        this.requestId = requestId;
    }

    public String getId() {
        return id;
    }

    public Salary getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public Area getArea() {
        return area;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Employer getEmployer() {
        return employer;
    }

    public String getDescription() {
        return description;
    }
}