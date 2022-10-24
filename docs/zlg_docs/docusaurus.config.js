const lightCodeTheme = require('prism-react-renderer/themes/github');
const darkCodeTheme = require('prism-react-renderer/themes/dracula');

// With JSDoc @type annotations, IDEs can provide config autocompletion
/** @type {import('@docusaurus/types').DocusaurusConfig} */
(module.exports = {
  title: 'ZL-G Docs',
  tagline: 'Everything about the ZL-G Platform and Tools',
  url: 'https://c100-099.cloud.gwdg.de.com',
  baseUrl: '/docs/',
  onBrokenLinks: 'throw',
  onBrokenMarkdownLinks: 'warn',
  favicon: 'img/favicon.ico',
  organizationName: 'imi', // Usually your GitHub org/user name.
  projectName: 'zlg_platform', // Usually your repo name.

  presets: [
    [
      '@docusaurus/preset-classic',
      /** @type {import('@docusaurus/preset-classic').Options} */
      ({
        docs: {
          sidebarPath: require.resolve('./sidebars.js'),
          // Please change this to your repo.
          //editUrl: 'https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/zlg-platform',
        },
        /** 
        blog: {
          showReadingTime: true,
          // Please change this to your repo.
          //editUrl: 'https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/zlg-platform',
        }, */
        theme: {
          customCss: require.resolve('./src/css/custom.css'),
        },
      }),
    ],
  ],

  themeConfig:
    /** @type {import('@docusaurus/preset-classic').ThemeConfig} */
    ({
      navbar: {
        title: 'ZL-G - Docs',
        logo: {
          alt: 'My Site Logo',
          src: 'img/logo.svg',
        },
        items: [
          {
            type: 'doc',
            docId: 'home',
            position: 'left',
            label: 'Documentation',
          },
          //{to: '/blog', label: 'Blog', position: 'left'},
          {
            href: 'https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/zlg-platform',
            label: 'GitLab',
            position: 'right',
          },
        ],
      },
      footer: {
        style: 'dark',
        links: [
          {
            title: 'Docs',
            items: [
              {
                label: 'Intro',
                to: '/docs/home',
              },
            ],
          },
          {
            title: 'Zukunftslabor Gesundheit',
            items: [
              {
                label: 'Zukunftslabor Gesundheit @ZDIN',
                href: 'https://www.zdin.de/zukunftslabore/gesundheit',
              },
              {
                label: 'ZL-G @Gitlab',
                href: 'https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit',
              },
              {
                label: 'ZL-G Platform @Gitlab',
                href: 'https://gitlab.gwdg.de/medinf/ivf/zukunftslabor-gesundheit/zlg-platform',
              },
            ],
          },
          {
            title: 'More',
            items: [
              //{
              //  label: 'Blog',
              //  to: '/blog',
              //},
              {
                label: 'ZDIN',
                href: 'https://www.zdin.de',
              },
              {
                label: 'Imprint',
                href: '/docs/docs/misc/imprint'
              }
            ],
          },
        ],
        copyright: `Copyright © ${new Date().getFullYear()} Zukunftslabor Gesundheit, ZDIN. Built with Docusaurus.`,
      },
      prism: {
        theme: lightCodeTheme,
        darkTheme: darkCodeTheme,
      },
    }),
});
