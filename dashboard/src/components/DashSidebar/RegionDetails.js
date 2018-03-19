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
        <h2>Management Team</h2>
        <ul>
          <li>Project Manager: {pm.firstName} {pm.lastName}</li>
          <li>Project Manager: {pc.firstName} {pc.lastName}</li>
          <li>Project Manager: {cm.firstName} {cm.lastName}</li>
        </ul>
      </section>
    </header>
    )
  }
}
 
export default RegionDetails;