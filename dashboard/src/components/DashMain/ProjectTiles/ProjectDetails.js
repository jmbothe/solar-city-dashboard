import React, { Component } from 'react';

class ProjectDetails extends Component {

  getCostPerWatt = () =>
    (this.props.projectInView.budget / (this.props.projectInView.megawatts * 1000000)).toFixed(2);

  getManHours = () => {
    // get number of weeks, multiply by 40, multiply by crew.length
    const p = this.props.projectInView;

    const weeksToCompletion = (Date.parse(p.dateCommission) - Date.parse(p.dateSurvey)) / 6.048e+8;
    return Math.floor(weeksToCompletion * 40 * this.props.crew.length);
  }

  render() {
    const p = this.props.projectInView;

    return (
      <section className="project-details-tile">
        <div className="tile-heading">
        <h3>Project Details</h3>
        </div>
        <ul>
          <li>Project ID: {p.projectId}</li>
          <li>Project Name: {p.projectName}</li>
          <li>Client: {p.client}</li>
          <li>Site Address:<br/>{p.address}<br />{p.city}, {p.zipcode}</li>
          <li>Megawatts: {p.megawatts}</li>
          <li>Budget: {p.budget}</li>
          <li>$/W: {this.getCostPerWatt()}</li>
          <li>Projected Man Hours: {this.getManHours()}</li>
          <li><a href={p.linkPlans} target="_blank" rel="noopener noreferrer">Design Plan</a></li>
          <li><a href={p.linkContract} target="_blank" rel="noopener noreferrer">Contract</a></li>
          <li><a href={p.linkEnvImpactReport} target="_blank" rel="noopener noreferrer">Environmental Impact Report</a></li>
        </ul>

      </section>
    )
  }
}
 
export default ProjectDetails;