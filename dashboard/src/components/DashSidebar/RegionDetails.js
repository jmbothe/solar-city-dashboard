import React, { Component } from 'react';

class RegionDetails extends Component {
  render() {
    const pm = this.props.management.projectManager;
    const pc = this.props.management.projectCoordinator;
    const cm = this.props.management.constructionManager;

    return (
      <section>
        <ul className="team-ul">
          <li>
            <span>Project Manager:</span>
            <br/>
            {pm.firstName} {pm.lastName}
            <br/>
            {pm.phoneNumber}
            <br/>
              {
                <a
                  href={`mailto:${pm.email}`}
                  target="_blank" rel="noopener noreferrer"
                  >
                    {pm.email}
                </a>
              }
            </li>
          <li>
            <span>Project Coordinator:</span>
            <br/>
            {pc.firstName} {pc.lastName}
            <br/>
            {pc.phoneNumber}
            <br/>
              {
                <a
                  href={`mailto:${pc.email}`}
                  target="_blank" rel="noopener noreferrer"
                  >
                    {pc.email}
                </a>
              }
            </li>
          <li>
            <span>Construction Manager:</span><br/>{cm.firstName} {cm.lastName}
            <br/>
            {cm.phoneNumber}
            <br/>
              {
                <a
                  href={`mailto:${cm.email}`}
                  target="_blank" rel="noopener noreferrer"
                  >
                    {cm.email}
                </a>
              }
            </li>
        </ul>
      </section>
    )
  }
}
 
export default RegionDetails;