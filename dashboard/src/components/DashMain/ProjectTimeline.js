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

  render() {
    const p = this.props.projectInView;
    const data =[
      ['Survey', p.dateSurvey, p.surveyComplete, 'surveyComplete'],
      ['Contract', p.dateContract, p.contractSigned, 'contractSigned'],
      ['Construction', p.dateStartConstruction, p.constructionStarted, 'constructionStarted'],
      ['Interconnection', p.dateInterconnection, p.interconnected, 'interconnected'],
      ['Operable', p.dateOperable, p.operable, 'operable'],
      ['Commission', p.dateCommission, p.commissioned, 'commissioned']
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
                  checked={!!set[2]}
                  onChange={() => this.props.toggleMilestone(p.projectId, set[3])}  
                />
              </div>
              <span className="milestone-date">{new Date(set[1]).toLocaleDateString()}</span>
              <span>{this.getMilestoneStatus(set[1], set[2])}</span>
            </div>
          )
        }
      </header>
    )
  }
}
 
export default ProjectTimeline;