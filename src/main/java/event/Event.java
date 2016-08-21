package event;


import event.enums.EventType;

import java.util.Date;
import java.util.UUID;

/**
 * The type Event.
 */
public class Event {
    private UUID id;
    private String eventType;
    private Date eventTimeStamp;
    private Date createTime;
    private Date deliveryTime;
    private Date endTime;
    private String serviceType;
    private String originationPage;
    private String agentId;
    private String endReason;
    private String originationChannel;


    /**
     * Instantiates a new Event.
     */
    public Event() {
        this.id = UUID.randomUUID();
        this.createTime = new Date();
        this.eventType = EventType.START.name();
    }

    public UUID getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getEventTimeStamp() {
        return eventTimeStamp;
    }

    public void setEventTimeStamp(Date eventTimeStamp) {
        this.eventTimeStamp = eventTimeStamp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getOriginationPage() {
        return originationPage;
    }

    public void setOriginationPage(String originationPage) {
        this.originationPage = originationPage;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getEndReason() {
        return endReason;
    }

    public void setEndReason(String endReason) {
        this.endReason = endReason;
    }

    public String getOriginationChannel() {
        return originationChannel;
    }

    public void setOriginationChannel(String originationChannel) {
        this.originationChannel = originationChannel;
    }
}
