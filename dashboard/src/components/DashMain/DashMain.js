import React from 'react';
import ProjectView from './ProjectView/ProjectView';

// TODO: Add CrewView: a list of all crew members, with functionality to fire/hire crew
// Different from CrewList, which allows for adding/removing crew members to/from projects

const DashMain = ({
  projectInView,
  crew,
  assignCrewMember,
  updateNotes,
  changeNotes,
  toggleMilestone
}) =>
  <ProjectView
    projectInView={projectInView}
    crew={crew}
    assignCrewMember={assignCrewMember}
    updateNotes={updateNotes}
    changeNotes={changeNotes}
    toggleMilestone={toggleMilestone}
  />

export default DashMain;