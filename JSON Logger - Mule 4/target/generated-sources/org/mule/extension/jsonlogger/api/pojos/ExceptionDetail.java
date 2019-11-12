
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
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "type",
    "message",
    "stackTrace",
    "errorCode"
})
public class ExceptionDetail {

    @JsonProperty("description")
    @Parameter
    @Optional(defaultValue = "#[error.description default \"\"]")
    @Summary("exception description details")
    @Expression(ExpressionSupport.SUPPORTED)
    private String description;
    @JsonProperty("type")
    @Parameter
    @Optional(defaultValue = "#[error.errorType.namespace default \"\" ++ \":\" ++ error.errorType.identifier default \"\"]")
    @Summary("error type")
    @Expression(ExpressionSupport.SUPPORTED)
    private String type;
    @JsonProperty("message")
    @Parameter
    @Optional(defaultValue = "#[error.detailedDescription default \"\"]")
    @Summary("error message")
    @Expression(ExpressionSupport.SUPPORTED)
    private String message;
    @JsonProperty("stackTrace")
    @Parameter
    @Optional(defaultValue = "#[error.cause.stackTrace as String default \"\" ]")
    @Summary("error message")
    @Expression(ExpressionSupport.SUPPORTED)
    private String stackTrace;
    @JsonProperty("errorCode")
    @Parameter
    @Optional
    @Summary("unique error code")
    @Expression(ExpressionSupport.SUPPORTED)
    private String errorCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("stackTrace")
    public String getStackTrace() {
        return stackTrace;
    }

    @JsonProperty("stackTrace")
    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    @JsonProperty("errorCode")
    public String getErrorCode() {
        return errorCode;
    }

    @JsonProperty("errorCode")
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
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
        return new HashCodeBuilder().append(description).append(type).append(message).append(stackTrace).append(errorCode).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExceptionDetail) == false) {
            return false;
        }
        ExceptionDetail rhs = ((ExceptionDetail) other);
        return new EqualsBuilder().append(description, rhs.description).append(type, rhs.type).append(message, rhs.message).append(stackTrace, rhs.stackTrace).append(errorCode, rhs.errorCode).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
