import React, {useEffect, useState, Component} from 'react';
import { connect } from 'react-redux';
import { useTable, usePagination } from 'react-table'
import "./Table.css"

class BuildTable extends Component {
  render(){
    const [filter, setFilter] = useState("");
    const [data, setData] = useState(this.props.hotel_data);

    const columns = React.useMemo(
    () => [
      {
        Header: 'No',
        accessor: 'id' // accessor is the "key" in the data
      },
      {
        Header: 'Nama Hotel',
        accessor: 'name'
      }, {
        Header: 'Kota',
        accessor: "kota"
      }, {
        Header: 'Jumlah Kamar',
        accessor: "kamar"
      }, {
        Header: 'Kamar Terpakai',
        accessor: "terpakai"
      }, {
        Header: 'Kamar Tersedia',
        accessor: "tersedia"
      }
    ], []
    )

    const {
      getTableProps,
      getTableBodyProps,
      headerGroups,
      // rows,
      page,
      nextPage,
      previousPage,
      pageOptions,
      gotoPage,
      pageCount,
      state,
      prepareRow
    } = useTable({ columns, data }, usePagination)
  
    const { pageIndex } = state;

    useEffect(() => {
          console.log(filter);
          const filterResult = initialData.filter(res => res.col2.toLowerCase().includes(filter.toLowerCase()))
          setData(filterResult)
      }, [filter]
    )

    return (
      <div className="hero-content">
      
        <input type="text" name="filter" onChange={e => setFilter(e.target.value)} />
        
        <table {...getTableProps()}>
          <thead>
            {
              headerGroups.map(headerGroup => (
                <tr {...headerGroup.getHeaderGroupProps()}>
                  {
                    headerGroup.headers.map(column => (
                      <th {...column.getHeaderProps()}>
                        {column.render('Header')}
                      </th>
                    ))
                  }
                </tr>
              ))
            }
          </thead>
  
          <tbody {...getTableBodyProps()}>
            {page.map(row => {
              prepareRow(row)
              return (
                <tr {...row.getRowProps()}>
                  {row.cells.map(cell => {
                    return (
                      <td {...cell.getCellProps()}>
                        {cell.render('Cell')}
                      </td>
                    )
                  })}
                </tr>
              )
            })}
          </tbody>
        </table>
  
        <div className="pagination">
              <ul>
                  <li className="firstPage" onClick={() => gotoPage(0)}>
                      {'<<'}
                  </li>
                  <li className="previousButton" onClick={() => previousPage()}>
                      <span>
                          Previous 
                      </span>
                  </li>
                  <li className="searchPage">
                      <span>
                          Go to page : {' '}
                          <input style={{width:"50px"}} type="number" defaultValue={pageIndex + 1} onChange={e => {
                              const pageNumber = e.target.value ? Number(e.target.value) - 1 : 0
                              gotoPage(pageNumber)
                          }}
                          />
                      </span>
                  </li>
                  <li className="pageInfo">
                      <span>
                          Page{' '}
                          <strong>
                              {pageIndex + 1} of {pageOptions.length}
                          </strong>{' '}
                      </span>
                  </li>
                  <li className="nextButton" onClick={() => nextPage()}>
                      <span>
                          Next
                      </span>
                  </li>
                  <li className="lastPage" onClick={() => gotoPage(pageCount - 1)}>
                      {'>>'}
                  </li>
              </ul>
          </div>
      </div>
    )
  }
}
// const BuildTable = () => {
//   // const initialData = [
//   //   {
//   //     col1: '1',
//   //     col2: 'Severus',
//   //     col3: 'Laki-laki',
//   //     col4: '20',
//   //     col5:'Jakarta'
//   //   },
//   //   {
//   //     col1: '1',
//   //     col2: 'Severus',
//   //     col3: 'Laki-laki',
//   //     col4: '20',
//   //     col5:'Jakarta'
//   //   },
//   //   {
//   //     col1: '1',
//   //     col2: 'Severus',
//   //     col3: 'Laki-laki',
//   //     col4: '20',
//   //     col5:'Jakarta'
//   //   },
//   //   {
//   //     col1: '1',
//   //     col2: 'Severus',
//   //     col3: 'Laki-laki',
//   //     col4: '20',
//   //     col5:'Jakarta'
//   //   },
//   //   {
//   //     col1: '1',
//   //     col2: 'Severus',
//   //     col3: 'Laki-laki',
//   //     col4: '20',
//   //     col5:'Jakarta'
//   //   },
//   //   {
//   //     col1: '1',
//   //     col2: 'Severus',
//   //     col3: 'Laki-laki',
//   //     col4: '20',
//   //     col5:'Jakarta'
//   //   },
//   //   {
//   //     col1: '1',
//   //     col2: 'Severus',
//   //     col3: 'Laki-laki',
//   //     col4: '20',
//   //     col5:'Jakarta'
//   //   },
//   // ]
  
//   const [filter, setFilter] = useState("")
//   const [data, setData] = useState(initialData)

//   const columns = React.useMemo(
//     () => [
//       {
//         Header: 'No',
//         accessor: 'id' // accessor is the "key" in the data
//       },
//       {
//         Header: 'Nama Hotel',
//         accessor: 'name'
//       }, {
//         Header: 'Kota',
//         accessor: "kota"
//       }, {
//         Header: 'Jumlah Kamar',
//         accessor: "kamar"
//       }, {
//         Header: 'Kamar Terpakai',
//         accessor: "terpakai"
//       }, {
//         Header: 'Kamar Tersedia',
//         accessor: "tersedia"
//       }
//     ], []
//   )

//   const {
//     getTableProps,
//     getTableBodyProps,
//     headerGroups,
//     // rows,
//     page,
//     nextPage,
//     previousPage,
//     pageOptions,
//     gotoPage,
//     pageCount,
//     state,
//     prepareRow
//   } = useTable({ columns, data }, usePagination)

//   const { pageIndex } = state;

//   useEffect(() => {
//     console.log(filter);
//     // let filterResult = initialData
//     // if(filter)
//     const filterResult = initialData.filter(res => res.col2.toLowerCase().includes(filter.toLowerCase()))
//       setData(filterResult)
//   }, [filter])

//   return (
//     <div className="hero-content">
    
//       <input type="text" name="filter" onChange={e => setFilter(e.target.value)} />
      
//       <table {...getTableProps()}>
//         <thead>
//           {
//             headerGroups.map(headerGroup => (
//               <tr {...headerGroup.getHeaderGroupProps()}>
//                 {
//                   headerGroup.headers.map(column => (
//                     <th {...column.getHeaderProps()}>
//                       {column.render('Header')}
//                     </th>
//                   ))
//                 }
//               </tr>
//             ))
//           }
//         </thead>

//         <tbody {...getTableBodyProps()}>
//           {page.map(row => {
//             prepareRow(row)
//             return (
//               <tr {...row.getRowProps()}>
//                 {row.cells.map(cell => {
//                   return (
//                     <td {...cell.getCellProps()}>
//                       {cell.render('Cell')}
//                     </td>
//                   )
//                 })}
//               </tr>
//             )
//           })}
//         </tbody>
//       </table>

//       <div className="pagination">
//             <ul>
//                 <li className="firstPage" onClick={() => gotoPage(0)}>
//                     {'<<'}
//                 </li>
//                 <li className="previousButton" onClick={() => previousPage()}>
//                     <span>
//                         Previous 
//                     </span>
//                 </li>
//                 <li className="searchPage">
//                     <span>
//                         Go to page : {' '}
//                         <input style={{width:"50px"}} type="number" defaultValue={pageIndex + 1} onChange={e => {
//                             const pageNumber = e.target.value ? Number(e.target.value) - 1 : 0
//                             gotoPage(pageNumber)
//                         }}
//                         />
//                     </span>
//                 </li>
//                 <li className="pageInfo">
//                     <span>
//                         Page{' '}
//                         <strong>
//                             {pageIndex + 1} of {pageOptions.length}
//                         </strong>{' '}
//                     </span>
//                 </li>
//                 <li className="nextButton" onClick={() => nextPage()}>
//                     <span>
//                         Next
//                     </span>
//                 </li>
//                 <li className="lastPage" onClick={() => gotoPage(pageCount - 1)}>
//                     {'>>'}
//                 </li>
//             </ul>
//         </div>
//     </div>
//   )
// }

const mapStateToProps = (state) => ({
  hotel_data: state.HotelData.data
})

export default connect(mapStateToProps)(BuildTable);
