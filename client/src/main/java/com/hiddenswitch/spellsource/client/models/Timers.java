/*
 * Hidden Switch Spellsource API
 * The Spellsource API for matchmaking, user accounts, collections management and more
 *
 * OpenAPI spec version: 1.0.1
 * Contact: benjamin.s.berman@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.hiddenswitch.spellsource.client.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * Information about timers. This helps the client render the countdown clock. 
 */
@ApiModel(description = "Information about timers. This helps the client render the countdown clock. ")

public class Timers implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("millisRemaining")
  private Long millisRemaining = null;

  public Timers millisRemaining(Long millisRemaining) {
    this.millisRemaining = millisRemaining;
    return this;
  }

   /**
   * The number of milliseconds remaining before the server will end the mulligan or turn. When null or less than zero, no timer is set. This property will be valid with respect to the last timestamped message from the server. Since typically emotes and touches are not timestamped, while other game state messages are, this property will be updated with actions and data. It is the responsibility of the client to lerp the millis-remaining values with the actual animated timer to prevent choppy animation. 
   * @return millisRemaining
  **/
  @ApiModelProperty(value = "The number of milliseconds remaining before the server will end the mulligan or turn. When null or less than zero, no timer is set. This property will be valid with respect to the last timestamped message from the server. Since typically emotes and touches are not timestamped, while other game state messages are, this property will be updated with actions and data. It is the responsibility of the client to lerp the millis-remaining values with the actual animated timer to prevent choppy animation. ")
  public Long getMillisRemaining() {
    return millisRemaining;
  }

  public void setMillisRemaining(Long millisRemaining) {
    this.millisRemaining = millisRemaining;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Timers timers = (Timers) o;
    return Objects.equals(this.millisRemaining, timers.millisRemaining);
  }

  @Override
  public int hashCode() {
    return Objects.hash(millisRemaining);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Timers {\n");
    
    sb.append("    millisRemaining: ").append(toIndentedString(millisRemaining)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

