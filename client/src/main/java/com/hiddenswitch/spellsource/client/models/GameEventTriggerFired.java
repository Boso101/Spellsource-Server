/*
 * Hidden Switch Spellsource API
 * The Spellsource API for matchmaking, user accounts, collections management and more.  To get started, create a user account and make sure to include the entirety of the returned login token as the X-Auth-Token header. You can reuse this token, or login for a new one.  ClientToServerMessage and ServerToClientMessage are used for the realtime game state and actions two-way websocket interface for actually playing a game. Envelope is used for the realtime API services. 
 *
 * OpenAPI spec version: 2.0.0
 * Contact: ben@hiddenswitch.com
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
import com.hiddenswitch.spellsource.client.models.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * GameEventTriggerFired
 */

public class GameEventTriggerFired implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("triggerSourceId")
  private Integer triggerSourceId = null;

  @JsonProperty("triggerSource")
  private Entity triggerSource = null;

  public GameEventTriggerFired description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A plain text description of an explanation of this trigger firing. 
   * @return description
  **/
  @ApiModelProperty(value = "A plain text description of an explanation of this trigger firing. ")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GameEventTriggerFired triggerSourceId(Integer triggerSourceId) {
    this.triggerSourceId = triggerSourceId;
    return this;
  }

   /**
   * The entity ID corresponding to the source of the trigger that got fired. 
   * @return triggerSourceId
  **/
  @ApiModelProperty(value = "The entity ID corresponding to the source of the trigger that got fired. ")
  public Integer getTriggerSourceId() {
    return triggerSourceId;
  }

  public void setTriggerSourceId(Integer triggerSourceId) {
    this.triggerSourceId = triggerSourceId;
  }

  public GameEventTriggerFired triggerSource(Entity triggerSource) {
    this.triggerSource = triggerSource;
    return this;
  }

   /**
   * Get triggerSource
   * @return triggerSource
  **/
  @ApiModelProperty(value = "")
  public Entity getTriggerSource() {
    return triggerSource;
  }

  public void setTriggerSource(Entity triggerSource) {
    this.triggerSource = triggerSource;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameEventTriggerFired gameEventTriggerFired = (GameEventTriggerFired) o;
    return Objects.equals(this.description, gameEventTriggerFired.description) &&
        Objects.equals(this.triggerSourceId, gameEventTriggerFired.triggerSourceId) &&
        Objects.equals(this.triggerSource, gameEventTriggerFired.triggerSource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, triggerSourceId, triggerSource);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameEventTriggerFired {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    triggerSourceId: ").append(toIndentedString(triggerSourceId)).append("\n");
    sb.append("    triggerSource: ").append(toIndentedString(triggerSource)).append("\n");
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

