
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
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "prettyPrint",
    "logLocationInfo",
    "disabledFields"
})
public class JsonOutput {

    @JsonProperty("prettyPrint")
    @Parameter
    @Optional(defaultValue = "true")
    @Summary("Indicate if log entries should be formatted or single line")
    @Expression(ExpressionSupport.SUPPORTED)
    private boolean prettyPrint;
    @JsonProperty("logLocationInfo")
    @Parameter
    @Optional(defaultValue = "true")
    @Summary("Indicate if location information should be logged")
    @Expression(ExpressionSupport.SUPPORTED)
    private boolean logLocationInfo;
    @JsonProperty("disabledFields")
    @Parameter
    @Optional
    @Summary("Indicate which fields should be disabled from logging separated by comma. They should match the exact name given in loggerProcessor.json schema")
    @Example("e.g. message, content")
    @Expression(ExpressionSupport.REQUIRED)
    private String disabledFields;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("prettyPrint")
    public boolean isPrettyPrint() {
        return prettyPrint;
    }

    @JsonProperty("prettyPrint")
    public void setPrettyPrint(boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
    }

    @JsonProperty("logLocationInfo")
    public boolean isLogLocationInfo() {
        return logLocationInfo;
    }

    @JsonProperty("logLocationInfo")
    public void setLogLocationInfo(boolean logLocationInfo) {
        this.logLocationInfo = logLocationInfo;
    }

    @JsonProperty("disabledFields")
    public String getDisabledFields() {
        return disabledFields;
    }

    @JsonProperty("disabledFields")
    public void setDisabledFields(String disabledFields) {
        this.disabledFields = disabledFields;
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
        return new HashCodeBuilder().append(prettyPrint).append(logLocationInfo).append(disabledFields).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JsonOutput) == false) {
            return false;
        }
        JsonOutput rhs = ((JsonOutput) other);
        return new EqualsBuilder().append(prettyPrint, rhs.prettyPrint).append(logLocationInfo, rhs.logLocationInfo).append(disabledFields, rhs.disabledFields).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
