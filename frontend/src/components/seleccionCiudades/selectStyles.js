const selectStyles = {
    option: (provided, state) => ({
      ...provided,
      borderBottom: '2px solid  #1DBEB4;',
      backgroundColor: state.isSelected?  "#1DBEB4": "#fff",       
      lastOfType: 'none',
      color: '#545776;',
      fontStyle: 'normal',
      fontSize: '10px',
      lineHeight: '10px',
      display:'flex'
      
    }),
    control:()=>({
      display:'flex',
      height: '38px',
      textAlign:'start',
      justifyContent: 'space-between',
      alignItems: 'center'
    }),

    singleValue: (provided, state) => {
      const opacity = state.isDisabled ? 0.5 : 1;
      const transition = 'opacity 300ms';
        
      return { ...provided, opacity, transition };
    }
  }

export default selectStyles;
