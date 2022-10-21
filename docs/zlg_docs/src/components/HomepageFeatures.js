import React from 'react';
import clsx from 'clsx';
import styles from './HomepageFeatures.module.css';

const FeatureList = [
  {
    title: 'Easily transform data',
    Svg: require('../../static/img/undraw_docusaurus_mountain.svg').default,
    description: (
      <>
        Find the documentation for the ZL-G openEHR_FLAT_Loader which allows you 
        to transform data from a tabular format to openEHR compositions via an Excel-Mapping File.
      </>
    ),
  },
  {
    title: 'Deploy your own platform',
    Svg: require('../../static/img/undraw_docusaurus_tree.svg').default,
    description: (
      <>
        Setup your own platform. Select components you need and combine them to fit your use case.
      </>
    ),
  },
  {
    title: 'Learn about openEHR',
    Svg: require('../../static/img/undraw_docusaurus_react.svg').default,
    description: (
      <>
        OpenEHR as well as FHIR are highly relevant for the exchange of interoperable data. Learn about openEHR using practical examples and find additional info.
      </>
    ),
  },
];

function Feature({Svg, title, description}) {
  return (
    <div className={clsx('col col--4')}>
      <div className="text--center">
        <Svg className={styles.featureSvg} alt={title} />
      </div>
      <div className="text--center padding-horiz--md">
        <h3>{title}</h3>
        <p>{description}</p>
      </div>
    </div>
  );
}

export default function HomepageFeatures() {
  return (
    <section className={styles.features}>
      <div className="container">
        <div className="row">
          {FeatureList.map((props, idx) => (
            <Feature key={idx} {...props} />
          ))}
        </div>
      </div>
    </section>
  );
}
