import React, {useEffect, useState} from 'react';
import './Home.css'
import { useTable } from 'react-table'

const Home = () => {
  const initialData = [
    {
      col1: '1',
      col2: 'Severus',
      col3: 'Laki-laki',
      col4: '20',
      col5:'Jakarta'
    },
    {
      col1: '1',
      col2: 'Severus',
      col3: 'Laki-laki',
      col4: '20',
      col5:'Jakarta'
    },
    {
      col1: '1',
      col2: 'Severus',
      col3: 'Laki-laki',
      col4: '20',
      col5:'Jakarta'
    },
    {
      col1: '1',
      col2: 'Severus',
      col3: 'Laki-laki',
      col4: '20',
      col5:'Jakarta'
    },
    {
      col1: '1',
      col2: 'Severus',
      col3: 'Laki-laki',
      col4: '20',
      col5:'Jakarta'
    },
    {
      col1: '1',
      col2: 'Severus',
      col3: 'Laki-laki',
      col4: '20',
      col5:'Jakarta'
    },
    {
      col1: '1',
      col2: 'Severus',
      col3: 'Laki-laki',
      col4: '20',
      col5:'Jakarta'
    },
  ]
  const [filter, setFilter] = useState("")
  const [data, setData] = useState(initialData)
  // const data = React.useMemo(
  //   () => [
  //     {
  //       col1: '1',
  //       col2: 'Severus',
  //       col3: 'Laki-laki',
  //       col4: '20',
  //       col5:'Jakarta'
  //     },
  //     {
  //       col1: '1',
  //       col2: 'Severus',
  //       col3: 'Laki-laki',
  //       col4: '20',
  //       col5:'Jakarta'
  //     },
  //     {
  //       col1: '1',
  //       col2: 'Severus',
  //       col3: 'Laki-laki',
  //       col4: '20',
  //       col5:'Jakarta'
  //     },
  //     {
  //       col1: '1',
  //       col2: 'Severus',
  //       col3: 'Laki-laki',
  //       col4: '20',
  //       col5:'Jakarta'
  //     },
  //     {
  //       col1: '1',
  //       col2: 'Severus',
  //       col3: 'Laki-laki',
  //       col4: '20',
  //       col5:'Jakarta'
  //     },
  //     {
  //       col1: '1',
  //       col2: 'Severus',
  //       col3: 'Laki-laki',
  //       col4: '20',
  //       col5:'Jakarta'
  //     },
  //     {
  //       col1: '1',
  //       col2: 'Severus',
  //       col3: 'Laki-laki',
  //       col4: '20',
  //       col5:'Jakarta'
  //     },
  //   ],
  //   []
  // )

  const columns = React.useMemo(
    () => [
      {
        Header: 'No',
        accessor: 'col1', // accessor is the "key" in the data
      },
      {
        Header: 'Nama',
        accessor: 'col2',
      },
      {
        Header: 'Jenis Kelamin',
        accessor: "col3"
      },
      {
        Header: 'Umur',
        accessor: "col4"
      },
      {
        Header: 'Alamat',
        accessor: "col5"
      },
    ],
    []
  )

  const {
    getTableProps,
    getTableBodyProps,
    headerGroups,
    rows,
    prepareRow,
  } = useTable({ columns, data })


  useEffect(() => {
    console.log(filter);
    // let filterResult = initialData
    // if(filter)
    const filterResult = initialData.filter(res => res.col2.toLowerCase().includes(filter.toLowerCase()))
    
      setData(filterResult)
  }, [filter])

  return (
    <div className="hero-content">
      <input type="text" name="filter" onChange={e => setFilter(e.target.value)} />
    <table {...getTableProps()} style={{ border: 'solid 1px blue' }}>
      <thead>
        {headerGroups.map(headerGroup => (
          <tr {...headerGroup.getHeaderGroupProps()}>
            {headerGroup.headers.map(column => (
              <th
                {...column.getHeaderProps()}
                style={{
                  borderBottom: 'solid 3px red',
                  background: 'aliceblue',
                  color: 'black',
                  fontWeight: 'bold',
                }}
              >
                {column.render('Header')}
              </th>
            ))}
          </tr>
        ))}
      </thead>
      <tbody {...getTableBodyProps()}>
        {rows.map(row => {
          prepareRow(row)
          return (
            <tr {...row.getRowProps()}>
              {row.cells.map(cell => {
                return (
                  <td
                    {...cell.getCellProps()}
                    style={{
                      padding: '10px',
                      border: 'solid 1px gray',
                      background: 'papayawhip',
                    }}
                  >
                    {cell.render('Cell')}
                  </td>
                )
              })}
            </tr>
          )
        })}
      </tbody>
    </table>
    </div>
  )
};


export default Home;
  // return (
  //   <div className="hero-content">
  //     <img src={logo} alt="" style={{  marginTop: '16px', marginBottom: '36px' }}/>
  //       <div className="hero-title">
  //         Lorem Ipsum
  //       </div>
  //       <div>
  //         <p className="hero-paragraph">
  //           Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
  //           Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
  //           Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
  //         </p>
  //         </div>
  //       </div>
  // );
