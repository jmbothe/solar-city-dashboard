import React, { Component } from 'react';

class RegionDetails extends Component {
  render() {
    const pm = this.props.management.projectManager;
    const pc = this.props.management.projectCoordinator;
    const cm = this.props.management.constructionManager;

    return (
      <header>
      <section>
        <h2>Region: {this.props.region.id}, {this.props.region.name}</h2>
      </section>
      <section>
        <h3>Management Team</h3>
        <ul>
          <li>
            Project Manager: {pm.firstName} {pm.lastName}
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
            Project Coordinator: {pc.firstName} {pc.lastName}
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
            Construction Manager: {cm.firstName} {cm.lastName}
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
    </header>
    )
  }
}
 
export default RegionDetails;