
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
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "appName",
    "appVersion",
    "env",
    "serverName"
})
public class GlobalSettings {

    @JsonProperty("appName")
    @Parameter
    @Optional(defaultValue = "${json.logger.application.name}")
    private String appName;
    @JsonProperty("appVersion")
    @Parameter
    @Optional(defaultValue = "${json.logger.application.version}")
    private String appVersion;
    @JsonProperty("env")
    @Parameter
    @Optional(defaultValue = "${mule.env}")
    private String env;
    @JsonProperty("serverName")
    @Parameter
    @Optional(defaultValue = "${mule.env}")
    private String serverName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("appName")
    public String getAppName() {
        return appName;
    }

    @JsonProperty("appName")
    public void setAppName(String appName) {
        this.appName = appName;
    }

    @JsonProperty("appVersion")
    public String getAppVersion() {
        return appVersion;
    }

    @JsonProperty("appVersion")
    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    @JsonProperty("env")
    public String getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(String env) {
        this.env = env;
    }

    @JsonProperty("serverName")
    public String getServerName() {
        return serverName;
    }

    @JsonProperty("serverName")
    public void setServerName(String serverName) {
        this.serverName = serverName;
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
        return new HashCodeBuilder().append(appName).append(appVersion).append(env).append(serverName).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GlobalSettings) == false) {
            return false;
        }
        GlobalSettings rhs = ((GlobalSettings) other);
        return new EqualsBuilder().append(appName, rhs.appName).append(appVersion, rhs.appVersion).append(env, rhs.env).append(serverName, rhs.serverName).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
