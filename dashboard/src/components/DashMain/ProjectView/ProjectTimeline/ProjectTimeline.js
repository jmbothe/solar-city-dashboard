import React, { Component } from 'react';

class ProjectTimeline extends Component {

  getMilestoneStatus = (date, status) => {
    if (status) {
      return 'Complete';
    } else if (Date.now() - Date.parse(date) > 0) {
      return 'Late';
    } else {
      return `${Math.floor((Date.parse(date) - Date.now()) / 8.64e+7)} days left`
    }
  }

  formatDate = date => {
    const d = new Date(date);
    const year = d.getFullYear();
    let month = '' + (d.getMonth() + 1);
    let day = '' + d.getDate();

    month = month.length < 2 ? '0' + month : month;
    day = day.length < 2 ? '0' + day : day;

    return [month, day, year].join('-');
  }
  
  render() {
    const p = this.props.projectInView;
    const data =[
      ['Survey', 'surveyComplete', 'dateSurvey'],
      ['Contract', 'contractSigned', 'dateContract'],
      ['Break Ground', 'constructionStarted', 'dateStartConstruction'],
      ['Interconnection', 'interconnected', 'dateInterconnection'],
      ['Operable', 'operable', 'dateOperable'],
      ['Commission', 'commissioned', 'dateCommission']
    ]
    return (
      <header className="milestone-header">
        <div className="milestone-container">
          <span>Timeline</span>
        </div>
        {
          data.map((set, index) =>
            <div key={index} className="milestone-container">
              <div>
                <span className="milestone-name">{set[0]}</span>
                <input
                  type="checkbox"
                  checked={!!p[set[1]]}
                  onChange={() => this.props.toggleMilestone(p.projectId, set[1])}  
                />
              </div>
              <span className="milestone-date">{this.formatDate(p[set[2]])}</span>
              <span>{this.getMilestoneStatus(p[set[2]], p[set[1]])}</span>
            </div>
          )
        }
      </header>
    )
  }
}
 
export default ProjectTimeline;