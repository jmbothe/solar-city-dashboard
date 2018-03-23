import React from 'react';
import ManagementCard from './ManagementCard';

const RegionDetails = ({
  management:
    {
      projectManager: pm,
      constructionManager: cm,
      projectCoordinator: pc,
    }
  }) =>
  <section>
    <ul className="team-ul">
      {
        [
          ['Project Manager', pm],
          ['Project Coordinator', pc],
          ['Construction Manager', cm]
        ]
        .map((manager) => <ManagementCard title={manager[0]} manager={manager[1]}/>)
      }
    </ul>
  </section>

export default RegionDetails;