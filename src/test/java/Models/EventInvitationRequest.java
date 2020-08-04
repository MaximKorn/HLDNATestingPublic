package Models;

public class EventInvitationRequest {
    String initiator;
    String eventName;
    String eventTheme;
    String organizationType;
    String senderOrganization;
    String inviterName;
    String partnershipForm;
    String eventStartDate;
    String eventEndDate;
    String invitationResponseDeadline;
    String eventProgram;
    String country;
    String city;
    String address;
    String commentCreation;
    String number;

    public EventInvitationRequest(String initiator, String eventName, String eventTheme, String organizationType,
                                  String senderOrganization, String inviterName, String partnershipForm, String eventProgram,
                                  String country, String city, String address, String commentCreation,
                                  String eventStartDate, String eventEndDate, String invitationResponseDeadline) {
        this.initiator = initiator;
        this.eventName = eventName;
        this.eventTheme = eventTheme;
        this.organizationType = organizationType;
        this.senderOrganization = senderOrganization;
        this.inviterName = inviterName;
        this.partnershipForm = partnershipForm;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.invitationResponseDeadline = invitationResponseDeadline;
        this.eventProgram = eventProgram;
        this.country = country;
        this.city = city;
        this.address = address;
        this.commentCreation = commentCreation;
    }

    public static EventInvitationRequest createEventInvitationRequestFromData(String[] requestData, String eventStartDate,
                                                                              String eventEndDate, String invitationResponseDeadline) {
        return new EventInvitationRequest(requestData[0], requestData[1], requestData[2], requestData[3], requestData[4],
                requestData[5], requestData[6], requestData[7], requestData[8], requestData[9], requestData[10], requestData[11],
                eventStartDate, eventEndDate, invitationResponseDeadline);
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public void setInvitationResponseDeadline(String invitationResponseDeadline) {
        this.invitationResponseDeadline = invitationResponseDeadline;
    }


    public void setRequestNumber(String requestNumber) {
        this.number = requestNumber;
    }

    public String getRequestNumber() {
        return this.number;
    }

    public String getInitiatorName() {
        return this.initiator;
    }

    public String getEventName() {
        return this.eventName;
    }

    public String getEventTheme() {
        return this.eventTheme;
    }

    public String getOrganizationType() {
        return this.organizationType;
    }

    public String getSenderOrganization() {
        return this.senderOrganization;
    }

    public String getInviterName() {
        return this.inviterName;
    }

    public String getPartnershipForm() {
        return this.partnershipForm;
    }

    public String getEventStartDate() {
        return this.eventStartDate;
    }

    public String getEventEndDate() {
        return this.eventEndDate;
    }

    public String getInvitationResponseDeadline() {
        return this.invitationResponseDeadline;
    }

    public String getEventProgram() {
        return this.eventProgram;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCity() {
        return this.city;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCommentCreation() {
        return this.commentCreation;
    }
}
