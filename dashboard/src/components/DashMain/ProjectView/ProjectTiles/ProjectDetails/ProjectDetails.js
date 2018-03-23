import React, { Component } from 'react';

class ProjectDetails extends Component {

  getCostPerWatt = () =>
    (this.props.projectInView.budget / (this.props.projectInView.megawatts * 1000000)).toFixed(2);

  // get number of weeks from start construction to interconnection,
  //multiply by 40 hrs per week, multiply by crew.length
  getManHours = () => {
    const p = this.props.projectInView;
    const weeksToCompletion = (Date.parse(p.dateInterconnection) - Date.parse(p.dateStartConstruction)) / 6.048e+8;
    return Math.floor(weeksToCompletion * 40 * this.props.crew.length);
  }

  numberWithCommas = (x) =>
    x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");


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
          <li>Budget: ${this.numberWithCommas(p.budget)}</li>
          <li>$/W: {this.getCostPerWatt()}</li>
          <li>Projected Man Hours: {this.numberWithCommas(this.getManHours())}</li>
          <li><a href={p.linkPlans} target="_blank" rel="noopener noreferrer">Design Plan</a></li>
          <li><a href={p.linkContract} target="_blank" rel="noopener noreferrer">Contract</a></li>
          <li><a href={p.linkEnvImpactReport} target="_blank" rel="noopener noreferrer">Environmental Impact Report</a></li>
        </ul>

      </section>
    )
  }
}
 
export default ProjectDetails;