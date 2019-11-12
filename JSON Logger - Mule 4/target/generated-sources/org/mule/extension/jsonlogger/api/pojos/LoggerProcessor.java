
package org.mule.extension.jsonlogger.api.pojos;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.dsl.xml.ParameterDsl;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Summary;


/**
 * Definition for fields used in the logger message processor
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "priority",
    "tracePoint",
    "correlationId",
    "logMessage",
    "orginationUserId",
    "orginationSystemId",
    "messageId",
    "errorDetail"
})
public class LoggerProcessor {

    @JsonProperty("priority")
    @Parameter
    @Optional(defaultValue = "INFO")
    @Summary("Logger priority")
    private Priority priority;
    @JsonProperty("tracePoint")
    @Parameter
    @Optional(defaultValue = "START")
    @Summary("Current processing stage")
    private TracePoint tracePoint;
    @JsonProperty("correlationId")
    @Parameter
    @Optional(defaultValue = "#[attributes.headers.correlationId]")
    @Expression(ExpressionSupport.SUPPORTED)
    private String correlationId;
    @JsonProperty("logMessage")
    @Parameter
    @Optional
    @Summary("Message to be logged")
    @Example("Add a log entry")
    @Expression(ExpressionSupport.SUPPORTED)
    private String logMessage;
    @JsonProperty("orginationUserId")
    @Parameter
    @Optional(defaultValue = "#[attributes.headers.originationUserId default \"\"]")
    @Expression(ExpressionSupport.SUPPORTED)
    private String orginationUserId;
    @JsonProperty("orginationSystemId")
    @Parameter
    @Optional(defaultValue = "#[attributes.headers.originationSystemId default \"\"]")
    @Expression(ExpressionSupport.SUPPORTED)
    private String orginationSystemId;
    @JsonProperty("messageId")
    @Parameter
    @Optional(defaultValue = "")
    @Expression(ExpressionSupport.SUPPORTED)
    private String messageId;
    @JsonProperty("errorDetail")
    @Parameter
    @Optional
    @DisplayName("Exception Configuration")
    @Expression(ExpressionSupport.NOT_SUPPORTED)
    @ParameterDsl(allowReferences = false)
    private ExceptionDetail errorDetail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("priority")
    public Priority getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @JsonProperty("tracePoint")
    public TracePoint getTracePoint() {
        return tracePoint;
    }

    @JsonProperty("tracePoint")
    public void setTracePoint(TracePoint tracePoint) {
        this.tracePoint = tracePoint;
    }

    @JsonProperty("correlationId")
    public String getCorrelationId() {
        return correlationId;
    }

    @JsonProperty("correlationId")
    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    @JsonProperty("logMessage")
    public String getLogMessage() {
        return logMessage;
    }

    @JsonProperty("logMessage")
    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    @JsonProperty("orginationUserId")
    public String getOrginationUserId() {
        return orginationUserId;
    }

    @JsonProperty("orginationUserId")
    public void setOrginationUserId(String orginationUserId) {
        this.orginationUserId = orginationUserId;
    }

    @JsonProperty("orginationSystemId")
    public String getOrginationSystemId() {
        return orginationSystemId;
    }

    @JsonProperty("orginationSystemId")
    public void setOrginationSystemId(String orginationSystemId) {
        this.orginationSystemId = orginationSystemId;
    }

    @JsonProperty("messageId")
    public String getMessageId() {
        return messageId;
    }

    @JsonProperty("messageId")
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @JsonProperty("errorDetail")
    public ExceptionDetail getErrorDetail() {
        return errorDetail;
    }

    @JsonProperty("errorDetail")
    public void setErrorDetail(ExceptionDetail errorDetail) {
        this.errorDetail = errorDetail;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(priority).append(tracePoint).append(correlationId).append(logMessage).append(orginationUserId).append(orginationSystemId).append(messageId).append(errorDetail).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LoggerProcessor) == false) {
            return false;
        }
        LoggerProcessor rhs = ((LoggerProcessor) other);
        return new EqualsBuilder().append(priority, rhs.priority).append(tracePoint, rhs.tracePoint).append(correlationId, rhs.correlationId).append(logMessage, rhs.logMessage).append(orginationUserId, rhs.orginationUserId).append(orginationSystemId, rhs.orginationSystemId).append(messageId, rhs.messageId).append(errorDetail, rhs.errorDetail).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
