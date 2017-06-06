
package foo.bar.client.json.entity;

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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "category",
    "create_time",
    "id",
    "modify_time",
    "name",
    "timezone",
    "user_id"
})
public class ProductDetail {

    @JsonProperty("category")
    private Category category;
    @JsonProperty("create_time")
    private String create_time;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("modify_time")
    private String modify_time;
    @JsonProperty("name")
    private String name;
    @JsonProperty("timezone")
    private Timezone timezone;
    @JsonProperty("user_id")
    private Integer user_id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductDetail() {
    }

    /**
     * 
     * @param create_time
     * @param user_id
     * @param timezone
     * @param modify_time
     * @param name
     * @param id
     * @param category
     */
    public ProductDetail(Category category, String create_time, Integer id, String modify_time, String name, Timezone timezone, Integer user_id) {
        super();
        this.category = category;
        this.create_time = create_time;
        this.id = id;
        this.modify_time = modify_time;
        this.name = name;
        this.timezone = timezone;
        this.user_id = user_id;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("create_time")
    public String getCreate_time() {
        return create_time;
    }

    @JsonProperty("create_time")
    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("modify_time")
    public String getModify_time() {
        return modify_time;
    }

    @JsonProperty("modify_time")
    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("timezone")
    public Timezone getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("user_id")
    public Integer getUser_id() {
        return user_id;
    }

    @JsonProperty("user_id")
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
        return new HashCodeBuilder().append(category).append(create_time).append(id).append(modify_time).append(name).append(timezone).append(user_id).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductDetail) == false) {
            return false;
        }
        ProductDetail rhs = ((ProductDetail) other);
        return new EqualsBuilder().append(category, rhs.category).append(create_time, rhs.create_time).append(id, rhs.id).append(modify_time, rhs.modify_time).append(name, rhs.name).append(timezone, rhs.timezone).append(user_id, rhs.user_id).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
