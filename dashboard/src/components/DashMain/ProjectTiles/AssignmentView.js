import React, { Component } from 'react';

class AssignmentView extends Component {
  
  handleAssignClick = (id, projectId) => {
    this.props.assignCrewMember(id, projectId);
  }

  render() { 
    return (
      <section className="crew-list-tile">
        <h3>Currently Available Crew Members</h3>
        <div className="crew-list-wrapper">
          <ul className="crew-list">
            {this.props.crew.map(member =>
                <li
                  key={member.employeeId}
                  className="crew-list-item"
                >
                  <div>
                    {member.firstName} {member.lastName}
                  <br/>
                  {member.phoneNumber}
                  {
                    <a
                      href={`mailto:${member.email}`}
                      target="_blank" rel="noopener noreferrer"
                      >
                        {member.email}
                    </a>
                  }
                  </div>
                <div>
                  <button onClick={() => this.handleAssignClick(member.employeeId, this.props.project.projectId)}>add</button>
                </div>
                </li>
              )
            }
            <button
                onClick={this.props.toggleAssignmentView}
              >
                exit
              </button>
          </ul>
        </div>
      </section>
    )
  }
}
 
export default AssignmentView;