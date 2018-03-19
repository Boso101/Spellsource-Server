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
import com.hiddenswitch.spellsource.client.models.Friend;
import com.hiddenswitch.spellsource.client.models.InventoryCollection;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Account
 */

public class Account implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("_id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("friends")
  private List<Friend> friends = null;

  @JsonProperty("decks")
  private List<InventoryCollection> decks = null;

  @JsonProperty("inMatch")
  private Boolean inMatch = null;

  @JsonProperty("personalCollection")
  private InventoryCollection personalCollection = null;

  public Account id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Account name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Account email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Account friends(List<Friend> friends) {
    this.friends = friends;
    return this;
  }

  public Account addFriendsItem(Friend friendsItem) {
    if (this.friends == null) {
      this.friends = new ArrayList<>();
    }
    this.friends.add(friendsItem);
    return this;
  }

   /**
   * Get friends
   * @return friends
  **/
  @ApiModelProperty(value = "")
  public List<Friend> getFriends() {
    return friends;
  }

  public void setFriends(List<Friend> friends) {
    this.friends = friends;
  }

  public Account decks(List<InventoryCollection> decks) {
    this.decks = decks;
    return this;
  }

  public Account addDecksItem(InventoryCollection decksItem) {
    if (this.decks == null) {
      this.decks = new ArrayList<>();
    }
    this.decks.add(decksItem);
    return this;
  }

   /**
   * Get decks
   * @return decks
  **/
  @ApiModelProperty(value = "")
  public List<InventoryCollection> getDecks() {
    return decks;
  }

  public void setDecks(List<InventoryCollection> decks) {
    this.decks = decks;
  }

  public Account inMatch(Boolean inMatch) {
    this.inMatch = inMatch;
    return this;
  }

   /**
   * True if the client should attempt to connect to a match with its token. 
   * @return inMatch
  **/
  @ApiModelProperty(value = "True if the client should attempt to connect to a match with its token. ")
  public Boolean isInMatch() {
    return inMatch;
  }

  public void setInMatch(Boolean inMatch) {
    this.inMatch = inMatch;
  }

  public Account personalCollection(InventoryCollection personalCollection) {
    this.personalCollection = personalCollection;
    return this;
  }

   /**
   * Get personalCollection
   * @return personalCollection
  **/
  @ApiModelProperty(value = "")
  public InventoryCollection getPersonalCollection() {
    return personalCollection;
  }

  public void setPersonalCollection(InventoryCollection personalCollection) {
    this.personalCollection = personalCollection;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(this.id, account.id) &&
        Objects.equals(this.name, account.name) &&
        Objects.equals(this.email, account.email) &&
        Objects.equals(this.friends, account.friends) &&
        Objects.equals(this.decks, account.decks) &&
        Objects.equals(this.inMatch, account.inMatch) &&
        Objects.equals(this.personalCollection, account.personalCollection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, friends, decks, inMatch, personalCollection);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    friends: ").append(toIndentedString(friends)).append("\n");
    sb.append("    decks: ").append(toIndentedString(decks)).append("\n");
    sb.append("    inMatch: ").append(toIndentedString(inMatch)).append("\n");
    sb.append("    personalCollection: ").append(toIndentedString(personalCollection)).append("\n");
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

