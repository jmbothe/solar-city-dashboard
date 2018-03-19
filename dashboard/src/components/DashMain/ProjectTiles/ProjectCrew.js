import React, { Component } from 'react';

class ProjectCrew extends Component {
  state = {}
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
                <button>Remove</button>
              </div>
            </li>
          )}
        </ul>
      </section>
    )
  }
}
 
export default ProjectCrew;