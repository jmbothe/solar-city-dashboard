import React, { Component } from 'react';

class CrewMemberCard extends Component {

  handleClick = (id, projectId = null) =>
    this.props.assignCrewMember(id, projectId);

  render() { 
    const member = this.props.member;

    return (
      <li
        key={member.employeeId}
        className="crew-list-item"
      >
        <div>
          {member.firstName} {member.lastName}
          <br/>
          {member.phoneNumber}
          <br/>
          {
            <a
              href={`mailto:${member.email}`}
              target="_blank" rel="noopener noreferrer"
              >
                {member.email}
            </a>
          }
        </div>
        <div className="crew-list-item-button-wrapper">
          <button
            onClick={
              this.props.assignmentView
                ? () => this.handleClick(member.employeeId, this.props.projectInView.projectId)
                : () => this.handleClick(member.employeeId)
            }
          >
            {this.props.assignmentView ? 'Add' : 'Remove'}
          </button>
        </div>
      </li>
    )
  }
}
 
export default CrewMemberCard;