import React, { Component } from 'react';

class ProjectCrew extends Component {
  
  handleClick = (id) => {
    this.props.unassignCrewMember(id);
  }

  render() { 
    return (
      <section>
        <h3>Crew</h3>
        <ul>
          {this.props.crew.map(member =>
           
            <li
              key={member.employeeId}
              className="crew-list-item"
            >
              <div>
                {member.employeeId} {member.firstName} {member.lastName}
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
                <button onClick={() => this.handleClick(member.employeeId)}>Remove</button>
              </div>
            </li>
          )}
        </ul>
      </section>
    )
  }
}
 
export default ProjectCrew;